package linzhanpicsynchironized.picremove.dao.javaMapper;

import linzhanpicsynchironized.picremove.dto.ThumIdAndAttachId;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface A001TongYongMapper {


    @Select({"select id from prdt_samp"})
    List<String> getAllPrdId();

    @Select({"select top 1 ThumbnailID as thumbId,ImageID as attachId from lzproductbasic where id=#{myPrdId}"})
    ThumIdAndAttachId getOneThumbnailIDAndOneAttachId(@Param("myPrdId") String myPrdId);

//    @Select({""})
    String getOneThumUrl(@Param("thumbnailID") String thumbnailID);

//    @Select({"select 'suoLueTuAndFuJian/'+LocalFileName+';' from  lzproductimage where FKID =#{attachId} "})
    List<String> getSomeAttachUrl(@Param("attachId") String attachId);

    @Update({"update prdt_samp set thum=#{thumUrl} where id=#{id}"})
    int updateMyThumUrl(@Param("thumUrl") String thumUrl,@Param("id") String id);

    @Update({"update prdt_samp set attach=#{attachUrls} where id=#{id}"})
    int updateMyAttach(@Param("attachUrls") String attachUrls,@Param("id") String id);
}
