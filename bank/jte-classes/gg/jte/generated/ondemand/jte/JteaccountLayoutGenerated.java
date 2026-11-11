package gg.jte.generated.ondemand.jte;
import edu.cwi.UserAccount;
import gg.jte.Content;
@SuppressWarnings("unchecked")
public final class JteaccountLayoutGenerated {
	public static final String JTE_NAME = "jte/accountLayout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,12,12,12,12,36,36,36,37,37,37,46,46,46,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content account, Content detail) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\r\n    <style>\r\n        body { font-family: Arial, sans-serif; margin: 0; background-color: #f4f6f8; display: flex; }\r\n        .sidebar { width: 250px; background: #333; color: #fff; height: 100vh; padding: 20px; box-sizing: border-box; }\r\n        .sidebar h2 { font-size: 1.2rem; margin-bottom: 20px; }\r\n        .sidebar a { display: block; color: #ccc; text-decoration: none; padding: 10px 0; }\r\n        .sidebar a:hover { color: #fff; }\r\n        .main-content { flex: 1; padding: 30px; box-sizing: border-box; }\r\n        .card { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); margin-bottom: 20px; }\r\n    </style>\r\n</head>\r\n<body>\r\n\r\n    <div class=\"sidebar\">\r\n        <h2>My Account</h2>\r\n        <a href=\"#profile\">Profile</a>\r\n        <a href=\"#settings\">Settings</a>\r\n        <a href=\"#billing\">Billing</a>\r\n        <a href=\"#logout\">Log Out</a>\r\n    </div>\r\n\r\n    <div class=\"main-content\">\r\n        <div class=\"card\">\r\n            <h2>Profile Information</h2>\r\n            <p><strong>");
		jteOutput.setContext("strong", null);
		jteOutput.writeUserContent(account);
		jteOutput.writeContent("</strong></p>\r\n            <p><strong>");
		jteOutput.setContext("strong", null);
		jteOutput.writeUserContent(detail);
		jteOutput.writeContent("</strong></p>\r\n        </div>\r\n        <div class=\"card\">\r\n            <h2>Account Settings</h2>\r\n            <p>Manage your password, notifications, and preferences here.</p>\r\n        </div>\r\n    </div>\r\n\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		Content account = (Content)params.get("account");
		Content detail = (Content)params.get("detail");
		render(jteOutput, jteHtmlInterceptor, title, account, detail);
	}
}
