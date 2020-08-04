package ru.vital1ks.being.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

public class CattailBlock extends Block implements net.minecraftforge.common.IPlantable {
   public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
   protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

   public CattailBlock(Block.Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE;
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      if (!state.isValidPosition(worldIn, pos)) {
         worldIn.destroyBlock(pos, true);
      } else if (worldIn.isAirBlock(pos.up())) {
         int i;
         for(i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
            ;
         }

         if (i < 2) {
            int j = state.get(AGE);
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
            if (j == 15) {
               worldIn.setBlockState(pos.up(), this.getDefaultState());
               worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 4);
            } else {
               worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
            }
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
            }
         }
      }

   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (!stateIn.isValidPosition(worldIn, currentPos)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
      }

      return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }

   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      BlockState soil = worldIn.getBlockState(pos.down());
      if (soil.canSustainPlant(worldIn, pos.down(), Direction.UP, this)) return true;
      Block block = worldIn.getBlockState(pos.down()).getBlock();
      if (block == this) {
         return true;
      } else {
         if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL) {
            BlockPos blockpos = pos.down();

            for(Direction direction : Direction.Plane.HORIZONTAL) {
               IFluidState ifluidstate = worldIn.getFluidState(blockpos.offset(direction, 2));
               if (ifluidstate.isTagged(FluidTags.WATER)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(AGE);
   }

   @Override
   public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
       return net.minecraftforge.common.PlantType.Beach;
   }

   @Override
   public BlockState getPlant(IBlockReader world, BlockPos pos) {
      return getDefaultState();
   }
   public boolean renderAsNormalBlock() {
       return false;
   }
}