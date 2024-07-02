import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class MethodChannelWidget extends StatelessWidget {
  const MethodChannelWidget({super.key});

  void getRingtones() async {
    const channel = MethodChannel("flutter_channel");
    final result = await channel.invokeMethod("getAll");
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Column(
        children: [
          ElevatedButton(
            onPressed: getRingtones,
            child: Text("Get ringtones"),
          ),
        ],
      ),
    );
  }
}
