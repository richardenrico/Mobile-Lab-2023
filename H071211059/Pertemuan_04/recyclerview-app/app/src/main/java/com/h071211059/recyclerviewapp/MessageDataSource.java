package com.h071211059.recyclerviewapp;

import java.util.ArrayList;

public class MessageDataSource {
    public static ArrayList<Message> messages = generateMessages();

    private static ArrayList<Message> generateMessages() {
        ArrayList<Message> conversation = new ArrayList<>();

        conversation.add(new Message("Hola, ¿cómo estás?", "10:00 AM", true));
        conversation.add(new Message("Hola, bien gracias. ¿Y tú?", "10:05 AM", false));
        conversation.add(new Message("Estoy bien también, gracias. ¿Qué planes tienes para hoy?", "10:10 AM", true));
        conversation.add(new Message("Pues hoy tengo que ir al supermercado y luego al gimnasio. ¿Y tú?", "10:15 AM", false));
        conversation.add(new Message("Tengo que trabajar hasta las 3 PM y luego probablemente vaya al cine. ¿Te gustaría ir conmigo?", "10:20 AM", true));
        conversation.add(new Message("Me encantaría, ¿a qué hora sería?", "10:25 AM", false));
        conversation.add(new Message("Podríamos ir a las 6 PM. ¿Te parece bien?", "10:30 AM", true));
        conversation.add(new Message("Perfecto, nos vemos a las 6 en el cine entonces. ¡Hasta luego!", "10:35 AM", false));
        conversation.add(new Message("¡Hasta luego, nos vemos allí!", "10:40 AM", true));
        conversation.add(new Message("Adios", "10:49 AM", false));

        return conversation;
    }
}
