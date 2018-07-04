package linzhanpicsynchironized.picremove.dto;

public class OnePrdtOneThumbSomeAttachUrl {
    private String productId;
    private String thumUrl;
    private String attachsUrls;

    public String getProductId() {
        return productId;
    }

    public OnePrdtOneThumbSomeAttachUrl setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getThumUrl() {
        return thumUrl;
    }

    public OnePrdtOneThumbSomeAttachUrl setThumUrl(String thumUrl) {
        this.thumUrl = thumUrl;
        return this;
    }

    public String getAttachsUrls() {
        return attachsUrls;
    }

    public OnePrdtOneThumbSomeAttachUrl setAttachsUrls(String attachsUrls) {
        this.attachsUrls = attachsUrls;
        return this;
    }
}
