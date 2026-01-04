#!/bin/bash

echo "Starting Aion BeckUp 2.4 Classic Chat Server."

/usr/lib/jvm/zulu8/bin/java  -Xms512m -Xmx1024m -ea -Xbootclasspath/p:./libs/jsr166.jar -cp ./libs/*:AL-Chat.jar com.aionemu.chatserver.ChatServer

if [ $? -eq 2 ]; then
echo "Administrator Restart..."
bash $0
elif [ $? -eq 1 ]; then
echo "Server terminated abnormally..."
else
echo "Server terminated..."
fi
