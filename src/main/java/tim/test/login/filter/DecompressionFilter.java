package tim.test.login.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;

public class DecompressionFilter extends AbstractValve{

	@Autowired
    private HttpServletRequest request;
	
	@Override
	public void invoke(PipelineContext pipelineContext) throws Exception {
		System.out.println("begin---this is a decompress fiter,method:" + request.getParameter("method"));
		request.setAttribute("decompression", "this is a new compress");
		pipelineContext.invokeNext();
		System.out.println("end---this is a decompress fiter");
	}

}
