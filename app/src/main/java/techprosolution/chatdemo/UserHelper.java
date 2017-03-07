package techprosolution.chatdemo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import techprosolution.chatdemo.dao.Users;
import techprosolution.chatdemo.dao.UsersDao;

/**
 * Created by vishalrandive on 08/03/17.
 */

public class UserHelper
{

    private HashMap<String, UserModel> generateUserHashMap(final String jsonArray){
        Gson gson = new Gson();
        HashMap<String, UserModel> userHashMap = new HashMap<>();
        Type listType = new TypeToken<List<UserModel>>(){}.getType();
        List<UserModel> myModelList = gson.fromJson(jsonArray, listType);
        for(int i =0 ;i< myModelList.size(); i++)
        {
            userHashMap.put(""+myModelList.get(i).id, myModelList.get(i));
            Log.e("user", myModelList.get(i).name);
        }
        return  userHashMap;
    }


    private UserModel getOwnProfile()
    {
        UserModel user = new UserModel();
        user.id = ChatActivity.OWN_ID;
        user.name = "Vishal";
        user.lastName = "Randive";
        user.profileRId = R.drawable.ic_own_profile;
        return user;
    }

    private UserModel getUserProfile()
    {
        UserModel user = new UserModel();
        user.id = 101;
        user.name = "Nataraj";
        user.lastName = "DB";
        user.profileRId = R.drawable.ic_user_profile;
        return user;
    }

    public HashMap<String, UserModel> getUsers()
    {
        List<UserModel> users = new ArrayList<>();
        users.add(getOwnProfile());
        users.add(getUserProfile());
        List<Users> usersDaoList = DBManager.getDaoSessionMain().getUsersDao().queryBuilder().orderDesc(UsersDao.Properties.Id).build().list();
        if(usersDaoList != null && usersDaoList.size()>0)
        {
            System.out.print("response :: " + usersDaoList.get(0).getResponse());
            return generateUserHashMap(usersDaoList.get(0).getResponse());
        }
        else
        {
            Gson gson = new GsonBuilder().create();
            JsonArray myCustomArray = gson.toJsonTree(users).getAsJsonArray();
            Users usersList = new Users(1L, myCustomArray.toString());
            DBManager.getDaoSessionMain().getUsersDao().insertOrReplace(usersList);
            return generateUserHashMap(myCustomArray.toString());
        }
    }

}
