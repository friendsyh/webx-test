package tim.test.login.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;

public class DecodeFilter extends AbstractValve{

	@Autowired
    private HttpServletRequest request;
	
	@Override
	public void invoke(PipelineContext pipelineContext) throws Exception {
		System.out.println("begin---this is a decode fiter,method:" + request.getParameter("method"));
		request.setCharacterEncoding("UTF-8");
		int size = request.getContentLength();
		InputStream is = request.getInputStream();
		byte[] reqBodyBytes = readBytes(is, size);
		request.setAttribute("newRequest", reqBodyBytes);
		pipelineContext.invokeNext();
		System.out.println("end---this is a decode fiter");
		
	}
	
	public static final byte[] readBytes(InputStream is, int contentLen) {
        if(contentLen > 0){
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try{
                while (readLen != contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {// Should not happen.
                        break;
                    }
                    readLen += readLengthThisTime;
                }
                return message;
            } catch (IOException e) {
                // Ignore
                // e.printStackTrace();
            }
        }
        return new byte[]{};
}

}
