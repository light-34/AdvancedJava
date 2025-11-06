package org.adv.nio;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Set;

public class PosixFilePermisionsDemo {
    public static void main(String[] args) {
        Path file = Paths.get("eye.png");

        //rwx -> permission for the owner full read-write-execute
        //r-- -> permission for the group read only
        //rw- -> permission for the others read-write only
        String permissionStr = "rwxr--rw-";
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString(permissionStr);

        //or use following
/*        Set<PosixFilePermission> permissions = EnumSet.of(
                PosixFilePermission.OWNER_READ,
                PosixFilePermission.OWNER_WRITE,
                PosixFilePermission.GROUP_READ,
                PosixFilePermission.OWNER_WRITE
        );
*/
        try {
            OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean();
            String name = mxBean.getName();
            if (name.startsWith("Mac") || name.startsWith("Linux")) {
                Files.setPosixFilePermissions(file, permissions);
            } else {
                System.out.println("System does not support " + name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
