package vip.linhs.stock.api.response;

public class GetOrdersDataResponse {

    public static final String YIBAO = "已报";
    public static final String YICHENG = "已成";
    public static final String YICHE = "已撤";

    /**
     * 买卖类别-买
     */
    public static final String B = "B";
    /**
     * 买卖类别-卖
     */
    public static final String S = "S";

    /**
     * 委托编号
     */
    private String Wtbh;
    /**
     * 委托时间
     * HHmmss
     */
    private String Wtsj;
    /**
     * 证券代码
     */
    private String Zqdm;
    /**
     * 委托数量
     */
    private String Wtsl;
    /**
     * 委托价格
     */
    private String Wtjg;
    /**
     * 委托状态
     *
     * @see #YIBAO
     * @see #YICHENG
     * @see #YICHE
     */
    private String Wtzt;
    /**
     * 买卖类别
     *
     * @see #B
     * @see #S
     */
    private String Mmlb;

    public String getWtbh() {
        return Wtbh;
    }

    public void setWtbh(String wtbh) {
        Wtbh = wtbh;
    }

    public String getWtsj() {
        return Wtsj;
    }

    public void setWtsj(String wtsj) {
        Wtsj = wtsj;
    }

    public String getZqdm() {
        return Zqdm;
    }

    public void setZqdm(String zqdm) {
        Zqdm = zqdm;
    }

    public String getWtsl() {
        return Wtsl;
    }

    public void setWtsl(String wtsl) {
        Wtsl = wtsl;
    }

    public String getWtjg() {
        return Wtjg;
    }

    public void setWtjg(String wtjg) {
        Wtjg = wtjg;
    }

    public String getWtzt() {
        return Wtzt;
    }

    public void setWtzt(String wtzt) {
        Wtzt = wtzt;
    }

    public String getMmlb() {
        return Mmlb;
    }

    public void setMmlb(String mmlb) {
        Mmlb = mmlb;
    }

}
