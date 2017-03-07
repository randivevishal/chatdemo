package techprosolution.chatdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import techprosolution.chatdemo.dao.Messages;
import techprosolution.chatdemo.dao.MessagesDao;

/**
 * Created by vishalrandive on 08/03/17.
 */

public class MessageHelper
{
    public void addMessages(List<MessageModel> messageModelList)
    {
        Gson gson = new GsonBuilder().create();
        JsonArray messageListArray = gson.toJsonTree(messageModelList).getAsJsonArray();
        Messages messages = new Messages(1L, messageListArray.toString());
        DBManager.getDaoSessionMain().getMessagesDao().insertOrReplace(messages);
    }

    public List<MessageModel> getMessages(){
        List<Messages> messagesDaoList = DBManager.getDaoSessionMain().getMessagesDao().queryBuilder().orderDesc(MessagesDao.Properties.Id).build().list();
        if(messagesDaoList != null && messagesDaoList.size()>0)
        {
            System.out.print("response messagesDaoList :: " + messagesDaoList.get(0).getResponse());
            Gson gson = new Gson();
            Type listType = new TypeToken<List<MessageModel>>(){}.getType();
            return gson.fromJson(messagesDaoList.get(0).getResponse(), listType);
        }
        return null;
    }

}
