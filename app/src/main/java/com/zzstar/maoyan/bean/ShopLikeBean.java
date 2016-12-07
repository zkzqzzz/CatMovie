package com.zzstar.maoyan.bean;

import java.util.List;

/**
 * Created by zzstar on 2016/12/6.
 */

public class ShopLikeBean {


    /**
     * data : {"list":[{"dealid":42611477,"notes":"","pic":"http://p1.meituan.net/348.348/movie/f4544a842f3d164e04070c4eab951e98174035.jpg@60q","price":29.9,"shortTitle":"电影珍藏版小说","title":"预售佩小姐的奇幻城堡电影珍藏版","value":38},{"dealid":42476275,"notes":"","pic":"http://p1.meituan.net/348.348/movie/d80268d857e22de707d53175ef885d3559753.jpg@60q","price":33,"shortTitle":"金属羽毛书签","title":"神奇动物在哪里 金属羽毛书签","value":48},{"dealid":41653896,"notes":"","pic":"http://p1.meituan.net/348.348/movie/f7cd66a17b70d75601a39716d127d1f8259056.jpg@60q","price":88,"shortTitle":"嗅嗅 公仔","title":"funko 神奇动物在哪里嗅嗅","value":128},{"dealid":42475387,"notes":"","pic":"http://p0.meituan.net/348.348/movie/be089cc7ce775581de17466955498098129498.jpg@60q","price":38,"shortTitle":"加厚吸管杯","title":"航海王 双层加厚吸管杯","value":59},{"dealid":42670001,"notes":"","pic":"http://p0.meituan.net/348.348/movie/b073d33e6507e663110f1c9c6250d20c68923.jpg@60q","price":69,"shortTitle":"风尚手链","title":"长城电影周边风尚手链","value":99},{"dealid":40184882,"notes":"","pic":"http://p0.meituan.net/348.348/movie/122bada636f8ce423939837c99380e7378478.jpg@60q","price":23.8,"shortTitle":"电影《我不是潘金莲》原著小说","title":"我不是潘金莲刘震云同名电影小说","value":29.8},{"dealid":42476415,"notes":"","pic":"http://p1.meituan.net/348.348/movie/8edbfc4dc0be06d16d89dbaf4220e8b5116131.jpg@60q","price":55,"shortTitle":"仿皮手机壳","title":"神奇动物在哪里 仿皮手机壳","value":79},{"dealid":41745243,"notes":"","pic":"http://p0.meituan.net/348.348/movie/a41842ccaa0f56f8b72889f1b0b7f8f8242530.jpg@60q","price":37.9,"shortTitle":"漫长的中场休息","title":"漫长的中场休息李安电影原著小说","value":45},{"dealid":42475679,"notes":"","pic":"http://p0.meituan.net/348.348/movie/91a39a90fe4a728f39281f6dba24da9f404694.jpg@60q","price":65,"shortTitle":"带支架手机壳","title":"航海王系列手机壳--带支架","value":98},{"dealid":41652712,"notes":"","pic":"http://p0.meituan.net/348.348/movie/077fefe241ef28dcf96b6b590b06796a286750.jpg@60q","price":88,"shortTitle":"纽特 公仔","title":"funko 神奇动物在哪里纽特","value":128}],"total":1487}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"dealid":42611477,"notes":"","pic":"http://p1.meituan.net/348.348/movie/f4544a842f3d164e04070c4eab951e98174035.jpg@60q","price":29.9,"shortTitle":"电影珍藏版小说","title":"预售佩小姐的奇幻城堡电影珍藏版","value":38},{"dealid":42476275,"notes":"","pic":"http://p1.meituan.net/348.348/movie/d80268d857e22de707d53175ef885d3559753.jpg@60q","price":33,"shortTitle":"金属羽毛书签","title":"神奇动物在哪里 金属羽毛书签","value":48},{"dealid":41653896,"notes":"","pic":"http://p1.meituan.net/348.348/movie/f7cd66a17b70d75601a39716d127d1f8259056.jpg@60q","price":88,"shortTitle":"嗅嗅 公仔","title":"funko 神奇动物在哪里嗅嗅","value":128},{"dealid":42475387,"notes":"","pic":"http://p0.meituan.net/348.348/movie/be089cc7ce775581de17466955498098129498.jpg@60q","price":38,"shortTitle":"加厚吸管杯","title":"航海王 双层加厚吸管杯","value":59},{"dealid":42670001,"notes":"","pic":"http://p0.meituan.net/348.348/movie/b073d33e6507e663110f1c9c6250d20c68923.jpg@60q","price":69,"shortTitle":"风尚手链","title":"长城电影周边风尚手链","value":99},{"dealid":40184882,"notes":"","pic":"http://p0.meituan.net/348.348/movie/122bada636f8ce423939837c99380e7378478.jpg@60q","price":23.8,"shortTitle":"电影《我不是潘金莲》原著小说","title":"我不是潘金莲刘震云同名电影小说","value":29.8},{"dealid":42476415,"notes":"","pic":"http://p1.meituan.net/348.348/movie/8edbfc4dc0be06d16d89dbaf4220e8b5116131.jpg@60q","price":55,"shortTitle":"仿皮手机壳","title":"神奇动物在哪里 仿皮手机壳","value":79},{"dealid":41745243,"notes":"","pic":"http://p0.meituan.net/348.348/movie/a41842ccaa0f56f8b72889f1b0b7f8f8242530.jpg@60q","price":37.9,"shortTitle":"漫长的中场休息","title":"漫长的中场休息李安电影原著小说","value":45},{"dealid":42475679,"notes":"","pic":"http://p0.meituan.net/348.348/movie/91a39a90fe4a728f39281f6dba24da9f404694.jpg@60q","price":65,"shortTitle":"带支架手机壳","title":"航海王系列手机壳--带支架","value":98},{"dealid":41652712,"notes":"","pic":"http://p0.meituan.net/348.348/movie/077fefe241ef28dcf96b6b590b06796a286750.jpg@60q","price":88,"shortTitle":"纽特 公仔","title":"funko 神奇动物在哪里纽特","value":128}]
         * total : 1487
         */

        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * dealid : 42611477
             * notes :
             * pic : http://p1.meituan.net/348.348/movie/f4544a842f3d164e04070c4eab951e98174035.jpg@60q
             * price : 29.9
             * shortTitle : 电影珍藏版小说
             * title : 预售佩小姐的奇幻城堡电影珍藏版
             * value : 38
             */

            private int dealid;
            private String notes;
            private String pic;
            private double price;
            private String shortTitle;
            private String title;
            private int value;

            public int getDealid() {
                return dealid;
            }

            public void setDealid(int dealid) {
                this.dealid = dealid;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getShortTitle() {
                return shortTitle;
            }

            public void setShortTitle(String shortTitle) {
                this.shortTitle = shortTitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
