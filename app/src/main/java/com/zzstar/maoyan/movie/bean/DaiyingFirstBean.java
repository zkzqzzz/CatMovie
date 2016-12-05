package com.zzstar.maoyan.movie.bean;

import java.util.List;

/**
 * Created by zzstar on 2016/12/4.
 */

public class DaiyingFirstBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * img : http://p1.meituan.net/movie/2cefee086c9547481bf695760e9cd19a16661.jpg
         * movieId : 342003
         * movieName : 萨利机长
         * name : 《萨利机长》首发版预告片
         * originName : 首发版预告片
         * url : http://maoyan.meituan.net/movie/videos/854x480c2f837c07f724ae88f031898de40dadc.mp4
         * videoId : 81730
         * wish : 16523
         */

        private String img;
        private int movieId;
        private String movieName;
        private String name;
        private String originName;
        private String url;
        private int videoId;
        private int wish;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginName() {
            return originName;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }
    }
}
