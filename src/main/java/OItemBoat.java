public class OItemBoat extends OItem {

    public OItemBoat(int paramInt) {
        super(paramInt);
        bb = 1;
    }

    @Override
    public OItemStack a(OItemStack paramOItemStack, OWorld paramOWorld, OEntityPlayer paramOEntityPlayer) {
        float f1 = 1.0F;

        float f2 = paramOEntityPlayer.y + (paramOEntityPlayer.w - paramOEntityPlayer.y) * f1;
        float f3 = paramOEntityPlayer.x + (paramOEntityPlayer.v - paramOEntityPlayer.x) * f1;

        double d1 = paramOEntityPlayer.m + (paramOEntityPlayer.p - paramOEntityPlayer.m) * f1;
        double d2 = paramOEntityPlayer.n + (paramOEntityPlayer.q - paramOEntityPlayer.n) * f1 + 1.62D - paramOEntityPlayer.H;
        double d3 = paramOEntityPlayer.o + (paramOEntityPlayer.r - paramOEntityPlayer.o) * f1;

        OVec3D localOVec3D1 = OVec3D.b(d1, d2, d3);

        float f4 = OMathHelper.b(-f3 * 0.01745329F - 3.141593F);
        float f5 = OMathHelper.a(-f3 * 0.01745329F - 3.141593F);
        float f6 = -OMathHelper.b(-f2 * 0.01745329F);
        float f7 = OMathHelper.a(-f2 * 0.01745329F);

        float f8 = f5 * f6;
        float f9 = f7;
        float f10 = f4 * f6;

        double d4 = 5.0D;
        OVec3D localOVec3D2 = localOVec3D1.c(f8 * d4, f9 * d4, f10 * d4);
        OMovingObjectPosition localOMovingObjectPosition = paramOWorld.a(localOVec3D1, localOVec3D2, true);
        if (localOMovingObjectPosition == null)
            return paramOItemStack;

        if (localOMovingObjectPosition.a == OEnumMovingObjectType.a) {
            int i = localOMovingObjectPosition.b;
            int j = localOMovingObjectPosition.c;
            int k = localOMovingObjectPosition.d;

            if (!paramOWorld.z) {
                // hMod: placing of a boat
                Block blockClicked = new Block(paramOWorld.a(i, j, k), i, j, k);
                blockClicked.setFaceClicked(Block.Face.fromId(localOMovingObjectPosition.e));
                Block blockPlaced = new Block(0, i, j, k);
                // hMod: Call hook
                if (paramOEntityPlayer instanceof OEntityPlayerMP && (Boolean) etc.getLoader().callHook(PluginLoader.Hook.ITEM_USE, ((OEntityPlayerMP) paramOEntityPlayer).getPlayer(), blockPlaced, blockClicked, new Item(paramOItemStack)))
                    return paramOItemStack;
                paramOWorld.a(new OEntityBoat(paramOWorld, i + 0.5F, j + 1.5F, k + 0.5F));
            }
            paramOItemStack.a -= 1;
        }

        return paramOItemStack;
    }
}
