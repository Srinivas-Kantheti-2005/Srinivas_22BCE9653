package com.example.srinivas_22bce9653.javaexs.lambdas;

public class DemoLambdas {
    public static void main(String args[]) {
//        Life before Lambda.
        MessageImpl message = new MessageImpl();
        message.sendMessage();

//        Life after Lambda.
        IMessage iMessage = () -> { System.out.println("Sending message from Lambda"); };
        iMessage.sendMessage();
    }
}
