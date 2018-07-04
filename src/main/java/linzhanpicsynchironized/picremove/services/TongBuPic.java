package linzhanpicsynchironized.picremove.services;


import linzhanpicsynchironized.picremove.dto.OnePrdtOneThumbSomeAttachUrl;
import linzhanpicsynchironized.picremove.CONST.C;
import linzhanpicsynchironized.picremove.dto.ThumIdAndAttachId;
import linzhanpicsynchironized.picremove.hanhan.p;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;


@Order(9)
@Component
public class TongBuPic {
//    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
@Autowired
private C c;
private  org.apache.log4j.Logger l = org.apache.log4j.LogManager.getLogger(this.getClass().getName());
//    只是说是 fixedRate 任务两次执行时间间隔是任务的开始点，而 fixedDelay 的间隔是前次任务的结束与下次任务的开始。
    @PostConstruct
    public void  doit(){
        try {
            Thread.sleep(1000*12);
//            Runnable runnable1 = new Runnable() {
//                int i=1;
//                public void run() {
                    long t1 = p.getTimeStamp();
                    String s1="--------------------------"+p.dtoStr(p.getDate(), p.d16)+"-----------------------------";
                    l.error(s1);


                    this.zuHe();


                    long t2 = p.getTimeStamp();
                    String s2="----------------------------------"+p.dtoStr(p.getDate(), p.d16)+"-----耗时-《"+(t2-t1)/1000+"》----秒----合计--《"+(t2-t1)/1000/60+"》-分钟----";
                    l.error(s2);
//                    i=i+1;
//                }
//            };



            //开启线程
//            runnable1.run();
            // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间,fixedRate就是当上次执行完间隔多少秒再执行
//            service.scheduleAtFixedRate(myThread, this.firstInitDelyTime,this.fixdelyTime, TimeUnit.SECONDS);


        } catch (Exception e) {
            e.printStackTrace();
            l.error(e.getMessage(),e);
        }
    }



    public void zuHe(){
        List<String> allPrdIds = this.getAllPrdId();
        if(p.notEmpty(allPrdIds)){
            for(String prdId:allPrdIds){
                if(p.notEmpty(prdId)){
                    ThumIdAndAttachId thumIdAndAttachId = this.getOneThumbnailIDAndSomeAttach(prdId);
                    if(p.notEmpty(thumIdAndAttachId)){
                        OnePrdtOneThumbSomeAttachUrl onePrdtOneThumbSomeAttachUrl = this.getOnePrdtOneThumbSomeAttachUrl(thumIdAndAttachId);
                        if(p.notEmpty(onePrdtOneThumbSomeAttachUrl)){
                            this.setMyUrlOfThumAndAttach(onePrdtOneThumbSomeAttachUrl);
                        }
                    }
                }
            }
        }
    }




//OnePrdtOneThumbSomeAttach

    //找到我们的打样系统的所有id
    public List<String> getAllPrdId(){
        List<String> list=c.a001TongYongMapper.getAllPrdId();
        return list;
    }

    //通过我们打样系统的id找到对应的别人打样系统的图片的ThumbnailID和附件ImageID(对方系统用这个当附件id)//用id对应id,结果只有一个
    public ThumIdAndAttachId getOneThumbnailIDAndSomeAttach(String myPrdId){
        ThumIdAndAttachId thumIdAndAttachId = c.a001TongYongMapper.getOneThumbnailIDAndOneAttachId(myPrdId);
        if(p.notEmpty(thumIdAndAttachId)){
            thumIdAndAttachId.setMyPrdId(myPrdId);
        }
        return thumIdAndAttachId;
    }


   //通过thumId和imageId找到对方系统中对应的一个缩略图名字和多个附件名字LocalFileName
    public OnePrdtOneThumbSomeAttachUrl getOnePrdtOneThumbSomeAttachUrl(ThumIdAndAttachId t){
        OnePrdtOneThumbSomeAttachUrl it=new OnePrdtOneThumbSomeAttachUrl();
       String thumUrl= c.a001TongYongMapper.getOneThumUrl(t.getThumbId() == null ? "" : t.getThumbId());
       it.setThumUrl(thumUrl==null?"":thumUrl);
       List<String>attaches=c.a001TongYongMapper.getSomeAttachUrl(t.getAttachId()==null?"":t.getAttachId());
        String attachs="";
        if(p.notEmpty(attaches)){
            for(String s:attaches){
                attachs=attachs+(s==null?"":s);
            }
        }
        it.setAttachsUrls(attachs);
        it.setProductId(t.getMyPrdId());
        return it;
    }


//设置我的系统中对应的缩略图路径和附件路径

    public void setMyUrlOfThumAndAttach(OnePrdtOneThumbSomeAttachUrl o){


        int i=c.a001TongYongMapper.updateMyThumUrl(o.getThumUrl()==null?"":o.getThumUrl(),
                null==o.getProductId()?"":o.getProductId());


        int k=c.a001TongYongMapper.updateMyAttach(o.getAttachsUrls()==null?"":o.getAttachsUrls(),
                null==o.getProductId()?"":o.getProductId());


    }

















}
