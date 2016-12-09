package com.zzstar.maoyan.bean;

import java.util.List;

/**
 * Created by majinqiang on 11/29/2016.
 */

public class Cinema {

    private ControlBean control;
    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        /**
         * expires : 43200
         */

        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {

        private List<CinemaBean> chaoyang;
        private List<CinemaBean> haidian;
        private List<CinemaBean> daxing;
        private List<CinemaBean> dongcheng;
        private List<CinemaBean> fengtai;
        private List<CinemaBean> xicheng;
        private List<CinemaBean> tongzhou;
        private List<CinemaBean> changping;
        private List<CinemaBean> fangshan;
        private List<CinemaBean> shunyi;
        private List<CinemaBean> mentougou;
        private List<CinemaBean> shijingshan;
        private List<CinemaBean> huairou;
        private List<CinemaBean> pinggu;
        private List<CinemaBean> miyun;
        private List<CinemaBean> yanqing;

        public List<CinemaBean> getchaoyang() {
            return chaoyang;
        }

        public void setchaoyang(List<CinemaBean> chaoyang) {
            this.chaoyang = chaoyang;
        }

        public List<CinemaBean> getYanQingBean() {
            return yanqing;
        }

        public void setyanqing(List<CinemaBean> YanQingBean) {
            this.yanqing = yanqing;
        }

        public List<CinemaBean> getHaiDianBean() {
            return haidian;
        }

        public void sethaidian(List<CinemaBean> HaiDianBean) {
            this.haidian = haidian;
        }

        public List<CinemaBean> getDongChengBean() {
            return dongcheng;
        }

        public void setdongcheng(List<CinemaBean> DongChengBean) {
            this.dongcheng = dongcheng;
        }

        public List<CinemaBean> getDaXingBean() {
            return daxing;
        }

        public void setdaxing(List<CinemaBean> DaXingBean) {
            this.daxing = daxing;
        }

        public List<CinemaBean> getTongZhouBean() {
            return tongzhou;
        }

        public void settongzhou(List<CinemaBean> TongZhouBean) {
            this.tongzhou = tongzhou;
        }

        public List<CinemaBean> getXiChengBean() {
            return xicheng;
        }

        public void setxicheng(List<CinemaBean> xicheng) {
            this.xicheng = xicheng;
        }

        public List<CinemaBean> getfengtai() {
            return fengtai;
        }

        public void setfengtai(List<CinemaBean> fengtai) {
            this.fengtai = fengtai;
        }

        public List<CinemaBean> getchangping() {
            return changping;
        }

        public void setchangping(List<CinemaBean> changping) {
            this.changping = changping;
        }

        public List<CinemaBean> getfangshan() {
            return fangshan;
        }

        public void setfangshan(List<CinemaBean> fangshan) {
            this.fangshan = fangshan;
        }

        public List<CinemaBean> getshunyi() {
            return shunyi;
        }

        public void setshunyi(List<CinemaBean> shunyi) {
            this.shunyi = shunyi;
        }

        public List<CinemaBean> getmentougou() {
            return mentougou;
        }

        public void setmentougou(List<CinemaBean> mentougou) {
            this.mentougou = mentougou;
        }

        public List<CinemaBean> getshijingshan() {
            return shijingshan;
        }

        public void setshijingshan(List<CinemaBean> shijingshan) {
            this.shijingshan = shijingshan;
        }

        public List<CinemaBean> gethuairou() {
            return huairou;
        }

        public void sethuairou(List<CinemaBean> huairou) {
            this.huairou = huairou;
        }

        public List<CinemaBean> getmiyun() {
            return miyun;
        }

        public void setmiyun(List<CinemaBean> miyun) {
            this.miyun = miyun;
        }

        public List<CinemaBean> getpinggu() {
            return pinggu;
        }

        public void setpinggu(List<CinemaBean> pinggu) {
            this.pinggu = pinggu;
        }

        public static class CinemaBean {


            private String addr;
            private int preferential;
            private int imax;
            private double lng;
            private double lat;
            private String brd;
            private String dis;
            private int deal;
            private int distance;
            private int follow;
            private int sellmin;
            private boolean sell;
            private String ct;
            private String nm;
            private int poiId;
            private String area;
            private int sellPrice;
            private int dealPrice;
            private int referencePrice;
            private int brdId;
            private int showCount;
            private int id;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public int getPreferential() {
                return preferential;
            }

            public void setPreferential(int preferential) {
                this.preferential = preferential;
            }

            public int getImax() {
                return imax;
            }

            public void setImax(int imax) {
                this.imax = imax;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public String getBrd() {
                return brd;
            }

            public void setBrd(String brd) {
                this.brd = brd;
            }

            public String getDis() {
                return dis;
            }

            public void setDis(String dis) {
                this.dis = dis;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public int getSellmin() {
                return sellmin;
            }

            public void setSellmin(int sellmin) {
                this.sellmin = sellmin;
            }

            public boolean isSell() {
                return sell;
            }

            public void setSell(boolean sell) {
                this.sell = sell;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPoiId() {
                return poiId;
            }

            public void setPoiId(int poiId) {
                this.poiId = poiId;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getSellPrice() {
                return sellPrice;
            }

            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            public int getDealPrice() {
                return dealPrice;
            }

            public void setDealPrice(int dealPrice) {
                this.dealPrice = dealPrice;
            }

            public int getReferencePrice() {
                return referencePrice;
            }

            public void setReferencePrice(int referencePrice) {
                this.referencePrice = referencePrice;
            }

            public int getBrdId() {
                return brdId;
            }

            public void setBrdId(int brdId) {
                this.brdId = brdId;
            }

            public int getShowCount() {
                return showCount;
            }

            public void setShowCount(int showCount) {
                this.showCount = showCount;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }


    }
}
