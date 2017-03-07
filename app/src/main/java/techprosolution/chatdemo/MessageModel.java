package techprosolution.chatdemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class MessageModel
{
    @SerializedName("message_id")
    public int id;

    @SerializedName("message_type")
    public int messageType;

    @SerializedName("message_text")
    public String messageText;

    @SerializedName("message_time")
    public String messageTime;

    @SerializedName("id")
    public int senderId;
}
