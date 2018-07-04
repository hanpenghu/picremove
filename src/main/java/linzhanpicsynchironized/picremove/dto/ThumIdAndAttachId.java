package linzhanpicsynchironized.picremove.dto;

public class ThumIdAndAttachId {

    private String myPrdId;
    private String thumbId;
    private String attachId;

    public String getThumbId() {
        return thumbId;
    }

    public ThumIdAndAttachId setThumbId(String thumbId) {
        this.thumbId = thumbId;
        return this;
    }

    public String getAttachId() {
        return attachId;
    }

    public ThumIdAndAttachId setAttachId(String attachId) {
        this.attachId = attachId;
        return this;
    }

    public String getMyPrdId() {
        return myPrdId;
    }

    public ThumIdAndAttachId setMyPrdId(String myPrdId) {
        this.myPrdId = myPrdId;
        return this;
    }
}
