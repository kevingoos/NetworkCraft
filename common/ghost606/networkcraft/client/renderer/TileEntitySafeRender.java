package ghost606.networkcraft.client.renderer;

import ghost606.networkcraft.resources.ResourceManager;
import ghost606.networkcraft.tileentities.TileEntitySafe;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TileEntitySafeRender extends TileEntitySpecialRenderer {

	private ModelChest chestModel = new ModelChest();

	public void renderTileEntityChest(TileEntitySafe tileEntity, double x,
			double y, double z, float partialTick) {
		bindTexture(ResourceManager.Block_Textures.Safe);

		int i = tileEntity.getBlockMetadata();

		GL11.glPushMatrix();
		GL11.glEnable(32826);

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) x, (float) y + 1.0F, (float) z + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);

		short short1 = 0;

		if (i == 2) {
			short1 = 180;
		}

		if (i == 3) {
			short1 = 0;
		}

		if (i == 4) {
			short1 = 90;
		}

		if (i == 5) {
			short1 = -90;
		}

		GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		float f1 = tileEntity.prevLidAngle
				+ (tileEntity.lidAngle - tileEntity.prevLidAngle) * partialTick;

		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		chestModel.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
		chestModel.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y,
			double z, float partialTick) {

		renderTileEntityChest((TileEntitySafe) tileEntity, x, y, z, partialTick);
	}
}