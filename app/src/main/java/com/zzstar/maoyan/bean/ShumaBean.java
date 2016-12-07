package com.zzstar.maoyan.bean;

import java.util.List;

/**
 * Created by zzstar on 2016/12/6.
 */

public class ShumaBean {


    /**
     * data : {"list":[{"dealid":33527771,"pic":"http://p1.meituan.net/348.348/movie/25e8de7ded0fe3ffcbdcc9c20bcc3709248829.jpg@60q","price":15,"title":"GetD格多维 3D偏光眼镜 近视夹片式","value":68},{"dealid":33412921,"pic":"http://p1.meituan.net/348.348/movie/876f599135fad5412778b4d31263653a629209.png","price":29.9,"title":"QQ游戏创意拉链耳机","value":108},{"dealid":36513561,"pic":"http://p0.meituan.net/348.348/movie/88738639d74c4bc31030f535f8803243465188.jpg@60q","price":58,"title":"超蝙正版6sPlus手机壳","value":78},{"dealid":37948183,"pic":"http://p0.meituan.net/348.348/movie/49298f3476b33f398590571d2adc1095226498.jpg@60q","price":168,"title":"美队3内战IOS苹果数据线","value":268},{"dealid":37323443,"pic":"http://p1.meituan.net/348.348/movie/196c2d88eb9021ba30a04cdc65b3229d96139.jpg@60q","price":179,"title":"钢铁侠蓝牙耳机EBT945","value":299},{"dealid":33433435,"pic":"http://p1.meituan.net/348.348.60/movie/5895cf62a945089088ce8153c70df42a97204.jpg","price":69,"title":"《哆啦A梦》萌睡机器猫手机架","value":89},{"dealid":36089501,"pic":"http://p1.meituan.net/348.348/movie/a3e746c155b81f95870086d4a56e2e0643744.jpg@60q","price":88,"title":"漫威正版美国队长USB游戏鼠标","value":118},{"dealid":40114633,"pic":"http://p1.meituan.net/348.348/movie/c84c7475e6c277cb353ea9ee14a5b9c071388.jpg@60q","price":69,"title":"星际迷航3正版公仔U盘16G","value":99},{"dealid":30332227,"pic":"http://p1.meituan.net/348.348.60/movie/eb6950b1e3c0f8108ab985ea304d8016120088.jpg","price":59.8,"title":"超人迷你便携式移动电源","value":77},{"dealid":33562544,"pic":"http://p0.meituan.net/348.348/movie/cbef1f6cb63697ba4e2bc90ee3c2db36601635.png","price":88,"title":"泡芙小姐水晶U盘","value":228}],"total":112}
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
         * list : [{"dealid":33527771,"pic":"http://p1.meituan.net/348.348/movie/25e8de7ded0fe3ffcbdcc9c20bcc3709248829.jpg@60q","price":15,"title":"GetD格多维 3D偏光眼镜 近视夹片式","value":68},{"dealid":33412921,"pic":"http://p1.meituan.net/348.348/movie/876f599135fad5412778b4d31263653a629209.png","price":29.9,"title":"QQ游戏创意拉链耳机","value":108},{"dealid":36513561,"pic":"http://p0.meituan.net/348.348/movie/88738639d74c4bc31030f535f8803243465188.jpg@60q","price":58,"title":"超蝙正版6sPlus手机壳","value":78},{"dealid":37948183,"pic":"http://p0.meituan.net/348.348/movie/49298f3476b33f398590571d2adc1095226498.jpg@60q","price":168,"title":"美队3内战IOS苹果数据线","value":268},{"dealid":37323443,"pic":"http://p1.meituan.net/348.348/movie/196c2d88eb9021ba30a04cdc65b3229d96139.jpg@60q","price":179,"title":"钢铁侠蓝牙耳机EBT945","value":299},{"dealid":33433435,"pic":"http://p1.meituan.net/348.348.60/movie/5895cf62a945089088ce8153c70df42a97204.jpg","price":69,"title":"《哆啦A梦》萌睡机器猫手机架","value":89},{"dealid":36089501,"pic":"http://p1.meituan.net/348.348/movie/a3e746c155b81f95870086d4a56e2e0643744.jpg@60q","price":88,"title":"漫威正版美国队长USB游戏鼠标","value":118},{"dealid":40114633,"pic":"http://p1.meituan.net/348.348/movie/c84c7475e6c277cb353ea9ee14a5b9c071388.jpg@60q","price":69,"title":"星际迷航3正版公仔U盘16G","value":99},{"dealid":30332227,"pic":"http://p1.meituan.net/348.348.60/movie/eb6950b1e3c0f8108ab985ea304d8016120088.jpg","price":59.8,"title":"超人迷你便携式移动电源","value":77},{"dealid":33562544,"pic":"http://p0.meituan.net/348.348/movie/cbef1f6cb63697ba4e2bc90ee3c2db36601635.png","price":88,"title":"泡芙小姐水晶U盘","value":228}]
         * total : 112
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
             * dealid : 33527771
             * pic : http://p1.meituan.net/348.348/movie/25e8de7ded0fe3ffcbdcc9c20bcc3709248829.jpg@60q
             * price : 15
             * title : GetD格多维 3D偏光眼镜 近视夹片式
             * value : 68
             */

            private int dealid;
            private String pic;
            private int price;
            private String title;
            private int value;

            public int getDealid() {
                return dealid;
            }

            public void setDealid(int dealid) {
                this.dealid = dealid;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
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
