import java.io.File;
import java.nio.file.Paths;

import javax.management.monitor.Monitor;

public class MonitorFiles  {
	
	
	public static void main(String[] args)   {
		
		if(args != null && args.length > 0) {
			String path = args[0];			
			

			File monitorFolder = new File(path);

			if(!monitorFolder.exists()){
				System.out.println("Not valid location");
				return;
			}

			if(!monitorFolder.isDirectory()){
				System.out.println("Path must be a directory");
				return;
			}

			//if we already have a path set to monitor start.
			FileMonitor mn = new FileMonitor(monitorFolder);
			mn.start();

								
		}

	}

}
