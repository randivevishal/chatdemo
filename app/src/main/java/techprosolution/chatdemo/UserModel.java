package techprosolution.chatdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class UserModel
{
    @SerializedName("id")
    public int id;

    @SerializedName("first_name")
    public String name;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("profile_image_rid") //resource id
    public int profileRId;

}
