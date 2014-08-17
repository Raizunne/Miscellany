package com.raizunne.miscellany.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

public class PacketHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {

	@Override
	public void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
		if(msg.channel().equals("Miscellany")){
			ByteBuf payload = msg.payload();
			
		}
		
	}

}
