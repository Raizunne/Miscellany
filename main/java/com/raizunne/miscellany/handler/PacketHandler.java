package com.raizunne.miscellany.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketHandler implements IMessageHandler<MiscMessage, IMessage> {

	@Override
	public IMessage onMessage(MiscMessage message, MessageContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
