package com.example.fragmentassigment;

import java.util.ArrayList;

public class PostDataSource {

    public static ArrayList<PostModel> dataList = generateDataDummyPostModels();

    private static ArrayList<PostModel> generateDataDummyPostModels() {
        ArrayList<PostModel> dataList = new ArrayList<>();

        dataList.add(new PostModel("Spider-Woman", "Jessica Drew", "side profile giving vogue magazine cover", "https://i.pinimg.com/564x/50/b5/bd/50b5bd663f2e5e21a5d642e81133c61a.jpg", "https://i.pinimg.com/564x/e7/b4/2d/e7b42da38abfa309e7ebdcfce8387466.jpg", "Jessica Drew (of Earth-616), also known as her alter-ego Spider-Woman, is a fictional character, a superheroine in the Marvel Comics Universe. Jessica Miriam Drew, daughter of Jonathan and Merriam Drew, was born in London, England.", "https://i.pinimg.com/564x/84/a9/64/84a9643ada762d0ff2e02b2711ec6726.jpg"));
        dataList.add(new PostModel("Spider-Man India", "Pavitr Prabhakar", "there's always time for a cup of tea.", "https://i.pinimg.com/564x/4e/69/d6/4e69d6ca407ff2485f8532fd46c1199b.jpg", "https://i.pinimg.com/564x/0e/be/d5/0ebed5e759aa41222ea7d41f98238399.jpg", "Paviitr Prabhakar (of Earth-50101) is an alternate version of Spider-Man/Peter Parker that was given the powers of a spider to become Spider-Man in India. Pavitr Prabhakar, is a poor Indian boy, lives in a village and moves to Mumbai with his aunt Maya and Uncle Bhim.", "https://i.pinimg.com/564x/d1/22/3b/d1223b50d71781c4f1ac47778e4bf31d.jpg"));
        dataList.add(new PostModel("Scarlet Spider", "Benjamin Ben Reilly ", "✌🏼", "https://i.pinimg.com/564x/8c/db/15/8cdb158fcf8a04694460c4445238a4d1.jpg", "https://i.pinimg.com/564x/72/b1/5f/72b15f7306e41e17a3fb9c290de8257d.jpg", "Ben Reilly is a genetic clone of Peter Parker, the super hero Spider-Man, who went on to determine his own identity as the Scarlet Spider. Ben was created by Miles Warren, the super villain known as the Jackal, to torment the hero, and seemingly died in their first encounter.", "https://i.pinimg.com/564x/73/89/b7/7389b79eb3496d2a4472250fdc00d687.jpg"));
        dataList.add(new PostModel("Spider-Man 2099", "Miguel O' Hara", "show my face? negative. are you ugly? quite the opposite.", "https://i.pinimg.com/564x/ce/b1/38/ceb138a57dbf375b0ff16f893d3a7009.jpg", "https://i.pinimg.com/564x/26/c7/8a/26c78a7946a9d8345623f039d97072e4.jpg", "Miguel meets with Lyla, who informs Miguel that the multiverse hasn't collapsed after the situation with Kingpin's collider. She also gives Miguel a wrist mounted multiversal travel device, which Lyla simply call a gizmo.", "https://i.pinimg.com/564x/82/3e/20/823e20739c5aedc08b0c6dbb720929a6.jpg"));
        dataList.add(new PostModel("Spider-UK", "Zarina Zahari", "the urge to let my hair down 😫", "https://i.pinimg.com/564x/3a/65/88/3a65884474c78bf530f26a4adee725c7.jpg", "https://i.pinimg.com/564x/3b/ca/7b/3bca7b22ef5d7af50e7b5a2a31a1199b.jpg", "Zarina grew up in London loving to play video-games. After getting powers, she became Spider-UK and joined W.H.O. (the Weird Happenings Organization) to help them fight superhuman threats. For the duration of Ramadan, Zarina would usually be dismissed from duty.", "https://i.pinimg.com/564x/b4/f0/0d/b4f00dc1570a93dc1f1e1de991ff37c6.jpg"));
        dataList.add(new PostModel("Spider-Ham", "Peter Porker", "hotdogs are the best thing ever no one can tell me otherwise. 🌭", "https://i.pinimg.com/564x/0e/21/6c/0e216ca0ea282f1d78684081c7febba9.jpg", "https://i.pinimg.com/564x/d6/1c/5a/d61c5a329679ff3134b1fe1ee5810274.jpg", "My name is Peter Porker. I was bitten by a radioactive pig. I'm a photographer for the Daily Beagle. When I'm not pooching around, I'm working like a dog trying to sniff out the latest story. I frolic and I dance, and I do this with my pants..", "https://i.pinimg.com/564x/a0/2c/46/a02c46cd454f3e8eba5168476c11bea9.jpg"));
        dataList.add(new PostModel("Peni Parker", "Peni Parker & SP//Dr", "i'll miss you forever. 🤍", "https://i.pinimg.com/564x/5f/36/ec/5f36ecb338437ef1b631713593f9b373.jpg", "https://i.pinimg.com/564x/fb/68/cd/fb68cdf9327507e3296950c1e9763a89.jpg", "Peni comes from New York in the year 3145 and was bitten by a radioactive spider who she developed a telepathic connection and became best friends with. Her deceased father left her the robot mech known as SP//dr, which she allowed the radioactive spider to pilot.", "https://i.pinimg.com/564x/31/1b/8f/311b8f5417a7d0862b314c050009d6ac.jpg"));
        dataList.add(new PostModel("Spider-Punk", "Hobart Hobie Brown", "guess who just bought a new guitar 🧐", "https://i.pinimg.com/564x/3b/dd/16/3bdd16c4dabfd573c11c9881b87d9a0b.jpg", "https://i.pinimg.com/564x/a8/6f/7d/a86f7dfee8b2c1637c2ecac811212f28.jpg","Foul-mouthed teenager Hobie Brown became a Spider-Totem after being bitten by a spider irradiated by illegal waste dumping. He proclaimed himself a Spider-Man and began to fight for freedom alongside his new friends Captain Anarchy (Karl Morningdew) and Hulk (Robbie Banner).",  "https://i.pinimg.com/564x/cc/85/99/cc859965cff4ba0413cfa765637b85b3.jpg"));
        dataList.add(new PostModel("Spider-Man Noir", "Peter Parker", "can someone pls help me finish this rubic 🚶🏻", "https://i.pinimg.com/564x/87/fd/87/87fd872d7ccad56dc087f5aa6485365d.jpg", "https://i.pinimg.com/736x/7f/5e/89/7f5e89097c61d2c5d0c1293f1aad04fc.jpg", "After being bitten by a mystical spider, this universe's Peter Parker was knocked out. He then sees a Spider-God that gives him the power of a spider when he wakes up. Peter Parker (of Earth-90214) is an alternate version of Peter Parker who was the Spider-Man of the 1930's.", "https://i.pinimg.com/564x/e2/11/ad/e211ad44481dd7ab1f767b51e14f3e23.jpg"));
        dataList.add(new PostModel("Spider-Man", "Peter B. Parker", "casually going to the movie with my suit on 🕺🏻", "https://i.pinimg.com/564x/f5/e5/12/f5e512ea18e808ca8383202051639891.jpg", "https://i.pinimg.com/564x/38/20/68/3820682622629c43fc48bf26b05a2d70.jpg", "My name is Peter B. Parker. I was bitten by a radioactive spider. And for the last twenty-two years, I thought I was the one and only Spider-Man. I'm pretty sure you know the rest. Y'see, I saved the city, fell in love, I got married, saved the city some more.", "https://i.pinimg.com/564x/d6/3f/61/d63f6171abf30e61c8cd755cfe19ebe0.jpg"));
        dataList.add(new PostModel("Spider-Gwen", "Gwen Stacy", "multitasking queen can be a super hero and a straight a's student at the same time. 💪🏼","https://i.pinimg.com/564x/a8/f4/99/a8f49918524b879a8dff409abe43a1dd.jpg", "https://i.pinimg.com/564x/8d/fe/0e/8dfe0e16e3c7c05f39b4be262bfa6e28.jpg", "My name is Gwen Stacy. I was bitten by a radioactive spider, And for the last two years, I've been the one and only Spider-Woman. You guys know the rest. I joined a band, saved my dad. I couldn't save my best friend, Peter Parker. So now I save everyone else, and I don't do friends anymore.",  "https://i.pinimg.com/736x/37/6f/3e/376f3e657292b16b32d638880bcbdd64.jpg"));

        return dataList;
    }

    public static ArrayList<PostModel> searchPostModels(String query) {
        ArrayList<PostModel> searchedPostModels = new ArrayList<>();

        for (int i = 0; i < dataList.size(); i++) {
            final PostModel postModel = dataList.get(i);
            String q = query.toLowerCase();
            String name = postModel.getName().toLowerCase();
            String username = postModel.getUsername().toLowerCase();
            if (name.startsWith(query) || username.startsWith(query)) {
                searchedPostModels.add(postModel);
            }
        }
        return searchedPostModels;
    }
}