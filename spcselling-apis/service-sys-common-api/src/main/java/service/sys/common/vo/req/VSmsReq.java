package service.sys.common.vo.req;

import com.spcs.apis.common.VBaseResp;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VSmsReq extends VBaseResp {

    @NotNull
    @NotEmpty
    private String mobile;

    @NotNull
    @NotEmpty
    @Size(min = 5,max = 30,message = "短信内容必须长度5-30个长度")
    private String content;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
