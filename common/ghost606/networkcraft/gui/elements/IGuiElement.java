package ghost606.networkcraft.gui.elements;

public interface IGuiElement {
	public void draw();
	public Boolean collide(int mouseX, int mouseY, int mouseButton);
}
