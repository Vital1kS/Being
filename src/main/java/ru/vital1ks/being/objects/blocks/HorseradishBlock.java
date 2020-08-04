package ru.vital1ks.being.objects.blocks;


	import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import ru.vital1ks.being.init.BlockInit;

	public class HorseradishBlock extends CropsBlock{
	   public static final IntegerProperty HORSERADISH_AGE = BlockStateProperties.AGE_0_3;
	   private static final VoxelShape[] SHAPE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};

	   public HorseradishBlock(Block.Properties properties) {
	      super(properties);
	   }

	   public IntegerProperty getAgeProperty() {
	      return HORSERADISH_AGE;
	   }

	   public int getMaxAge() {
	      return 3;
	   }

	   protected IItemProvider getSeedsItem() {
	      return BlockInit.horseradish_seeds;
	   }

	   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
	      if (rand.nextInt(3) != 0) {
	         super.tick(state, worldIn, pos, rand);
	      }

	   }

	   protected int getBonemealAgeIncrease(World worldIn) {
	      return super.getBonemealAgeIncrease(worldIn) / 3;
	   }

	   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(HORSERADISH_AGE);
	   }

	   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	      return SHAPE[state.get(this.getAgeProperty())];
	   }
	}