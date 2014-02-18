package net.fusejna.types;

import com.sun.jna.IntegerType;
import com.sun.jna.NativeLong;
import net.fusejna.Platform;

@SuppressWarnings("serial")
public class TypeBlkCnt extends IntegerType
{
	private static final int size;
	static {
		switch (Platform.platform()) {
			case MAC:
			case MAC_MACFUSE:
                size = 4;
                break;
			case FREEBSD:
				size = 8;
				break;
			case LINUX_I686:
			case LINUX_PPC:
				size = Platform.size(TypeLongLong.class);
				break;
			case LINUX_X86_64:
				size = Platform.size(NativeLong.class);
				break;
			default:
				size = 0;
		}
	}

	public TypeBlkCnt()
	{
		super(size);
	}

	public TypeBlkCnt(final long value)
	{
		super(size, value);
	}
}
