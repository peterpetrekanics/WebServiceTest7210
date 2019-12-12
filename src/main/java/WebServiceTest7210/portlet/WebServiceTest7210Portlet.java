package WebServiceTest7210.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import java.net.URLEncoder;
import com.liferay.portal.service.http.UserServiceSoap;
import com.liferay.portal.service.http.UserServiceSoapServiceLocator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.rpc.ServiceException;

import org.osgi.service.component.annotations.Component;

import WebServiceTest7210.constants.WebServiceTest7210PortletKeys;

/**
 * @author peterpetrekanics
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WebServiceTest7210",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + WebServiceTest7210PortletKeys.WEBSERVICETEST7210,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WebServiceTest7210Portlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
		
		UserServiceSoapServiceLocator locator = new UserServiceSoapServiceLocator();
		UserServiceSoap userService = null;
		long companyId = 20101;
		try {
			userService = locator.getPortal_UserService();
			long userCount = userService.getCompanyUsersCount(companyId);
			System.out.println("userCount:" + userCount);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}