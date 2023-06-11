package com.lev.chat;

import java.util.ArrayList;
import java.util.List;

public class DataChat {

    private static List<List<ModelBubble>>chats(){
        List<List<ModelBubble>>chats = new ArrayList<>();
        //orang
        List<ModelBubble>chat1= new ArrayList<>();
        chat1.add(new ModelBubble("Yang","20.00", true));
        chat1.add(new ModelBubble("Iya Ayang","20.05", false));
        chat1.add(new ModelBubble("Dimana?","20.05", true));
        chat1.add(new ModelBubble("Hotel","20.10", false));
        chat1.add(new ModelBubble("Ketemuan yuk di hotel","20.15", false));

        chats.add(chat1);

        List<ModelBubble>chat2= new ArrayList<>();
        chat2.add(new ModelBubble("Info Info Info","19.00", true));
        chat2.add(new ModelBubble("Ayang Kedua","19.05", false));

        chats.add(chat2);

        List<ModelBubble>chat3= new ArrayList<>();
        chat3.add(new ModelBubble("Info Info Info","18.00", true));
        chat3.add(new ModelBubble("Ayang Ketiga","18.05", false));

        chats.add(chat3);

        List<ModelBubble>chat4= new ArrayList<>();
        chat4.add(new ModelBubble("Info Info Info","17.00", true));
        chat4.add(new ModelBubble("Ayang Keempat","17.05", false));

        chats.add(chat4);

        List<ModelBubble>chat5= new ArrayList<>();
        chat5.add(new ModelBubble("Info Info Info","16.00", true));
        chat5.add(new ModelBubble("Ayang Kelima","16.05", false));

        chats.add(chat5);

        List<ModelBubble>chat6= new ArrayList<>();
        chat6.add(new ModelBubble("Info Info Info","15.00", true));
        chat6.add(new ModelBubble("Ayang Keenam","15.05", false));

        chats.add(chat6);

        List<ModelBubble>chat7= new ArrayList<>();
        chat7.add(new ModelBubble("Info Info Info","14.00", true));
        chat7.add(new ModelBubble("Ayang Ketujuh","14.05", false));

        chats.add(chat7);

        List<ModelBubble>chat8= new ArrayList<>();
        chat8.add(new ModelBubble("Info Info Info","13.00", true));
        chat8.add(new ModelBubble("Ayang Kedelapan","13.05", false));

        chats.add(chat8);

        List<ModelBubble>chat9= new ArrayList<>();
        chat9.add(new ModelBubble("Info Info Info","12.00", true));
        chat9.add(new ModelBubble("Ayang Kesembilan","12.05", false));

        chats.add(chat9);

        List<ModelBubble>chat10= new ArrayList<>();
        chat10.add(new ModelBubble("Info Info Info","11.00", true));
        chat10.add(new ModelBubble("Ayang Kesepuluh","11.05", false));

        chats.add(chat10);


        return chats;
    }

    public static ArrayList<ModelChat>
    ambilDataChat() {
        ArrayList<ModelChat> dataChat = new ArrayList<>();
        dataChat.add(new ModelChat("Christabel",chats().get(0), "https://awsimages.detik.net.id/community/media/visual/2019/03/17/fa0b6f31-5274-441d-b2a9-550436b73469.jpeg", "081234567890", "Selebgram Cantik Singapura", "21.00"));
        dataChat.add(new ModelChat("Bree", chats().get(1), "https://pbs.twimg.com/ext_tw_video_thumb/1470989634024841222/pu/img/iMaZslyt7J1zwCP7.jpg", "081204567890", "Viral", "21.30"));
        dataChat.add(new ModelChat("Billa", chats().get(2), "https://i.pinimg.com/736x/f1/aa/52/f1aa5261f7bc2ff34def142bc8f8397a.jpg", "081214567890", "Selebriti, Aktris, Wanita Terseksi", "20.08"));
        dataChat.add(new ModelChat("Alina", chats().get(3), "https://pbs.twimg.com/media/Fezy8R5acAId4XR.jpg", "081224567890", "On Riding", "20.02"));
        dataChat.add(new ModelChat("Gracy", chats().get(4), "https://pbs.twimg.com/media/EeVtig1UwAI2iW8.jpg:large", "081244567890", "Love You", "01.12"));
        dataChat.add(new ModelChat("Maria", chats().get(5), "https://s2.bukalapak.com/img/74091847003/s-330-330/data.jpeg.webp", "081254567890", "Online", "Kemarin 13.20"));
        dataChat.add(new ModelChat("Mia", chats().get(6), "https://cdn-2.tstatic.net/aceh/foto/bank/images/mia-khalifa-1.jpg", "081264567890", "Happy", "21.20"));
        dataChat.add(new ModelChat("Hibiki", chats().get(7), "https://tinhayvip.com/wp-content/uploads/2022/03/hibiki-otsuki-khien-fan-bat-ngo-truoc-nhan-sac-u30-2.jpg", "081274567890", "Lonely", "30 Feb 2023"));
        dataChat.add(new ModelChat("Yui", chats().get(8), "https://i.pinimg.com/originals/d2/84/78/d284786def883592baaed9030c524ae2.jpg", "081284567890", "Main", "10.09"));
        dataChat.add(new ModelChat("Ai", chats().get(9), "https://todayidol.com/wp-content/uploads/2016/05/Uehara-Ai-Ebisu-Muscats.jpg", "081294567890", "Gaming", "Recently"));
        return dataChat;


    }
}
