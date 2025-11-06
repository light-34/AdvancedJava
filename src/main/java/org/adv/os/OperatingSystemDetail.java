package org.adv.os;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class OperatingSystemDetail {
    public static void main(String[] args) {
        //Get OS name
        String osName = System.getProperty("os.name");
        //Get OS architecture
        String arch = System.getProperty("os.arch");
        //Get Os version
        String version = System.getProperty("os.version");
        System.out.println("OS: " + osName);
        System.out.println("Arch: " + arch);
        System.out.println("Version: " + version);

        System.out.println(moreComplexDetails());
    }

    public static String moreComplexDetails() {
        OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean();

        String name = mxBean.getName();
        String arch = mxBean.getArch();
        String version = mxBean.getVersion();

        int processors = mxBean.getAvailableProcessors();
        double loadAverage = mxBean.getSystemLoadAverage();

        return String.format("Name: %s\nArch: %s\nVersion: %s\nProcessors: %d\nLoad Average: %f", name, arch, version, processors, loadAverage);
    }
}
