package com.sarah.currencyTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private RestTemplate restTemplate = new RestTemplate();


    @Scheduled(fixedRate = 5000)
    public void printCurrency() {
        Coin coin = restTemplate.getForObject("https://api.cryptonator.com/api/ticker/btc-usd", Coin.class);
		log.info(coin.toString());
    }
}
