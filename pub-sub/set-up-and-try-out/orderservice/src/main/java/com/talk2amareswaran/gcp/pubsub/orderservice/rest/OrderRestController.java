package com.talk2amareswaran.gcp.pubsub.orderservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talk2amareswaran.gcp.pubsub.orderservice.OrderserviceApplication.PubsubOutboundGateway;

@RestController
public class OrderRestController {

	@Autowired
	private PubsubOutboundGateway messagingGateway;

	@PostMapping("/publish")
	public String publishMessage(@RequestParam("orderId") String orderId) {
		messagingGateway.sendToPubsub(orderId);
		return "The Order Id " + orderId + " is published successfully";
	}
	
}
