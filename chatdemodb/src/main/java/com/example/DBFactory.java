package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DBFactory
{
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "techprosolution.chatdemo.dao");
        schema.enableActiveEntitiesByDefault();
        schema.enableKeepSectionsByDefault();
        schema.enableActiveEntitiesByDefault();

        addUserList(schema);
        addMessageList(schema);

        new DaoGenerator().generateAll(schema, "../ChatDemo/app/src/main/java");
    }

    private static void addUserList(Schema schema) {
        Entity users = schema.addEntity("Users");
        users.addLongProperty("id").primaryKey();
        users.addStringProperty("response");
    }

    private static void addMessageList(Schema schema) {
        Entity messages = schema.addEntity("Messages");
        messages.addLongProperty("id").primaryKey();
        messages.addStringProperty("response");
    }

}

