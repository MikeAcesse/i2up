package info2soft.qa.auto.util;

import info2soft.qa.common.logging.ITestLogger;
import info2soft.qa.common.logging.LoggerFactory;
import info2soft.qa.common.util.CmdResult;
import info2soft.qa.common.util.CmdUtil;

public class SshUtil {
	private static String nodeUser ="root";
	private static int defaultTimeout = 600; //10 min
	protected static final ITestLogger logger = LoggerFactory.getLogger(SshUtil.class);

	public static CmdResult runCmdOnHost(String cmd, String host) {
    	return runCmdOnHost(cmd, host, false);
    }
	
	public static CmdResult runScpFromHost(String host, String src, String dest) {
    	return runScpFromHost(host, src, dest, false);
    }
	
	public static CmdResult runScpToHost(String host, String src, String dest) {
    	return runScpToHost(host, src, dest, false);
    }

    public static CmdResult runCmdOnHost(String cmd, String host, boolean runInshell) {
    	return runCmdOnHost(cmd, host, runInshell, defaultTimeout);
    }
    
    public static CmdResult runScpFromHost(String host, String src, String dest, boolean runInshell) {
    	return runScpFromHost(host, src, dest, runInshell, defaultTimeout);
    }
    
    public static CmdResult runScpToHost(String host, String src, String dest, boolean runInshell) {
    	return runScpToHost(host, src, dest, runInshell, defaultTimeout);
    }

    public static CmdResult runCmdOnHost(String cmd, String host, boolean runInshell, int timeout) {
    	CmdResult ret = null;
        try {
            ret = CmdUtil.runCmd(withSshOnHost(cmd, host), logger, runInshell, timeout);
        } catch (Exception ex) {
            logger.log("got error", ex);
        }
        return ret;
    }
    
    public static CmdResult runScpFromHost(String host, String src, String dest, boolean runInshell, int timeout) {
    	CmdResult ret = null;
        try {
            ret = CmdUtil.runCmd(withScpFromHost(host, src, dest), logger, runInshell, timeout);
        } catch (Exception ex) {
            logger.log("got error", ex);
        }
        return ret;
    }
    
    public static CmdResult runScpToHost(String host, String src, String dest, boolean runInshell, int timeout) {
    	CmdResult ret = null;
        try {
            ret = CmdUtil.runCmd(withScpToHost(host, src, dest), logger, runInshell, timeout);
        } catch (Exception ex) {
            logger.log("got error", ex);
        }
        return ret;
    }

    private static String withSshOnHost(String cmd, String host) {
        String sshOptions = "-o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null";
        return String.format("ssh %s %s@%s %s", sshOptions, nodeUser, host, cmd);
    }
    
    private static String withScpFromHost(String host, String src, String dest) {
    	String sshOptions = "-o StrictHostKeyChecking=no";
        return String.format("scp %s -r %s@%s:%s %s", sshOptions, nodeUser, host, src, dest);
    }
    
    private static String withScpToHost(String host, String src, String dest) {
    	String sshOptions = "-o StrictHostKeyChecking=no";
        return String.format("scp %s -r %s %s@%s:%s", sshOptions, src, nodeUser, host, dest);
    }
	
  public static void main(String args[]) {
	  //need to config ssh without password between ssh client/server
	  //1: "ssh-keygen -t rsa" on ssh client
	  //2: "scp .ssh/id_rsa.pub to ssh server" on ssh client
	  //3: "cat .ssh/id_rsa.pub >> .ssh/authorized_keys" on ssh server
	  //4: "chmod 600 .ssh/authorized_keys" on ssh server
//    System.out.println("111" + SshUtil.runCmdOnHost("ls", "172.20.77.53").getOutput());
//	  System.out.println(SshUtil.runScpFromHost("/root/sshd_config", ".", "172.20.77.53").getOutput());
//	  System.out.println(SshUtil.runScpToHost("TestData.json", "/root", "172.20.77.53").getOutput());
  }
}
