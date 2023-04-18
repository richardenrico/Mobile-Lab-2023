package com.example.recycleviewassignment;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Data> data = generateDummyData();

    private static ArrayList<Data> generateDummyData() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data("hyunjin", "good night", "https://i.pinimg.com/736x/4c/71/d9/4c71d9929655af9879bd82c5bf62996c.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("jay", "lagi apa?", "https://i.pinimg.com/564x/8b/aa/50/8baa50aaa6816f43b627be38aba8fb1d.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("taehyung", "udah makan?", "https://i.pinimg.com/564x/02/83/6a/02836a6945d3bd138c42c2937f4e7b26.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("jake", "pagii", "https://i.pinimg.com/564x/c8/33/8e/c8338e406e923173233d57672363ff23.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("haruto", "lagi apa?", "https://i.pinimg.com/564x/06/7c/10/067c1074de798779f62969ea421806e4.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("jisung", "lagi apa?", "https://i.pinimg.com/564x/f4/19/b0/f419b08bbe5d2315be0537617bb0aef9.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("ian", "lagi apa?", "https://i.pinimg.com/564x/48/8a/7c/488a7cd1a36bc386efbd45d474de3598.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("winwin", "lagi apa?", "https://i.pinimg.com/564x/c2/29/75/c22975c99b588fae14f0a8ac79bd52d9.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("niki", "lagi apa?", "https://i.pinimg.com/564x/1a/cf/9f/1acf9f405f1f64edbc4989c6d02989a4.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("han", "lagi apa?", "https://i.pinimg.com/564x/ab/6c/b5/ab6cb5afd5efe7e3c04693b51cba408b.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("suga", "lagi apa?", "https://i.pinimg.com/564x/e1/b2/52/e1b2523762b83363f8d743e1873af098.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("sunghoon", "lagi apa?", "https://i.pinimg.com/564x/3f/3d/d3/3f3dd31dc5fc14f56ec7eb77806d943b.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("yoonsu", "lagi apa?", "https://i.pinimg.com/564x/5e/a4/81/5ea481fb6efaa02f542739b7c268876e.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("youngdae", "lagi apa?", "https://i.pinimg.com/564x/26/d0/75/26d075738a5adb0c15967734c5c6200b.jpg", "21:28", "busy", "May 23, 2022"));
        data.add(new Data("wooshik", "lagi apa?", "https://i.pinimg.com/564x/72/cb/28/72cb28421d383d0b568718a0b0afd87c.jpg", "21:28", "busy", "May 23, 2022"));
        return data;
    }
}
