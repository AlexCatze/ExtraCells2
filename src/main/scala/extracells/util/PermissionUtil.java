package extracells.util;

import net.minecraft.entity.player.EntityPlayer;

import appeng.api.config.SecurityPermissions;
import appeng.api.networking.IGrid;
import appeng.api.networking.IGridHost;
import appeng.api.networking.IGridNode;
import appeng.api.networking.security.ISecurityGrid;
import appeng.api.parts.IPart;
import appeng.api.util.AEPartLocation;

public class PermissionUtil {

	public static boolean hasPermission(EntityPlayer player,
			SecurityPermissions permission, IGrid grid) {
		if (grid != null)
			return hasPermission(player, permission,
					(ISecurityGrid) grid.getCache(ISecurityGrid.class));
		return true;
	}

	public static boolean hasPermission(EntityPlayer player,
			SecurityPermissions permission, IGridHost host) {
		return hasPermission(player, permission, host, AEPartLocation.INTERNAL);
	}

	public static boolean hasPermission(EntityPlayer player,
			SecurityPermissions permission, IGridHost host, AEPartLocation side) {
		if (host != null)
			return hasPermission(player, permission, host.getGridNode(side));
		return true;
	}

	public static boolean hasPermission(EntityPlayer player,
			SecurityPermissions permission, IGridNode host) {
		if (host != null)
			return hasPermission(player, permission, host.getGrid());
		return true;
	}

	public static boolean hasPermission(EntityPlayer player,
			SecurityPermissions permission, IPart part) {
		if (part != null)
			return hasPermission(player, permission, part.getGridNode());
		return true;
	}

	public static boolean hasPermission(EntityPlayer player,
			SecurityPermissions permission, ISecurityGrid securityGrid) {
		if (player == null || permission == null || securityGrid == null)
			return true;
		return securityGrid.hasPermission(player, permission);
	}
}
