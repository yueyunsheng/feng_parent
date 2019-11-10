package com.feng.sms.utils;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

@Component
public class SmsUtil {

    public CommonResponse sendSmsResponse(String PhoneNumbers, String TemplateParam) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FcAm15u8o1dzUaekj9P", "wFPYrBuVtkKUdvYteiEGauzA7np3ac");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        CommonResponse response = null;
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", PhoneNumbers);
        request.putQueryParameter("SignName", "花肆");
        request.putQueryParameter("TemplateCode", "SMS_177240119");
        request.putQueryParameter("TemplateParam", TemplateParam);
        try {
            response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return response;
    }
}

