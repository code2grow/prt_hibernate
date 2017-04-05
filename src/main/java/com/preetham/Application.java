package com.preetham;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	//doesnt containt the shutdown case
	 /* public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
        }*/
//	---------- below code modified for gracefull shutdown
	public static void main(String[] args) throws Exception {
	    SpringApplication app = new SpringApplication(Application.class);
	    ConfigurableApplicationContext applicationContext = app.run(args);
//	    closeApp(app, applicationContext); // this shoud prints "Process finished with error code 5"

	}
	
	public static void closeApp(SpringApplication app, ConfigurableApplicationContext context) {
	    final int exitCode = 5;
	    ExitCodeGenerator exitCodeGenerator = new ExitCodeGenerator() {
	        @Override
	        public int getExitCode() {
	            return exitCode;
	        }
	    };
	    app.exit(context, exitCodeGenerator); 
	}

}
