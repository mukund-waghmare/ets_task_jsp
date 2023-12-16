package snippet;

public class Snippet {
	SEVERE: Servlet.service() for servlet [reg] in context with path [/UserRegistrationEx1] threw exception [Servlet execution threw an exception] with root cause
	java.lang.ClassNotFoundException: javax.xml.bind.JAXBException
		at org.apache.catalina.loader.WebappClassLoaderBase.loadClass(WebappClassLoaderBase.java:1412)
		at org.apache.catalina.loader.WebappClassLoaderBase.loadClass(WebappClassLoaderBase.java:1220)
		at org.hibernate.boot.spi.XmlMappingBinderAccess.<init>(XmlMappingBinderAccess.java:43)
		at org.hibernate.boot.MetadataSources.<init>(MetadataSources.java:87)
		at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.<init>(EntityManagerFactoryBuilderImpl.java:209)
		at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.<init>(EntityManagerFactoryBuilderImpl.java:171)
		at org.hibernate.jpa.boot.spi.Bootstrap.getEntityManagerFactoryBuilder(Bootstrap.java:76)
		at org.hibernate.jpa.HibernatePersistenceProvider.getEntityManagerFactoryBuilder(HibernatePersistenceProvider.java:181)
		at org.hibernate.jpa.HibernatePersistenceProvider.getEntityManagerFactoryBuilderOrNull(HibernatePersistenceProvider.java:129)
		at org.hibernate.jpa.HibernatePersistenceProvider.getEntityManagerFactoryBuilderOrNull(HibernatePersistenceProvider.java:71)
		at org.hibernate.jpa.HibernatePersistenceProvider.createEntityManagerFactory(HibernatePersistenceProvider.java:52)
		at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:55)
		at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:39)
		at Register.doGet(Register.java:37)
		at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
		at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
		at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227)
		at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)
		at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
		at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189)
		at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162)
		at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197)
		at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97)
		at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)
		at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135)
		at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)
		at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:687)
		at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78)
		at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:360)
		at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:399)
		at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
		at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:890)
		at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1789)
		at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
		at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)
		at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)
		at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
		at java.base/java.lang.Thread.run(Thread.java:833)
	
	
}

