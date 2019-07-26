package com.example.walletdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Author Miccke
 * @Description TODO
 * @Date $ $
 * @Version 2.0.4
 **/
@Service
public class BtcServiceImpl implements BtcService {

    private Logger LOG = LoggerFactory.getLogger("btc");

    @Autowired
    private CoinRpcClient client;

    @Override
    public boolean validateAddress(String address) throws RuntimeException {
        try {
            String res = (String) client.getClient().invoke("validateaddress", new Object[] { address }, Object.class);
            if (!StringUtils.isEmpty(res)) {
                JSONObject obj = JSON.parseObject(res);
                if (obj.getBoolean("isvalid") == true) {
                    return true;
                }
            }
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.validateAddress(String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: address=%s", address));
        }
        return false;
    }

    @Override
    public double getBalance(String account) throws RuntimeException {
        double balance;
        try {
            if (!StringUtils.isEmpty(account)) {
                balance = (double) client.getClient().invoke("getbalance", new Object[] { account }, Object.class);
            } else {
                balance = (double) client.getClient().invoke("getbalance", new Object[] {}, Object.class);
            }
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.getBalance(String...):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: account=%s", account));
        }
        return balance;
    }

    @Override
    public Object signSendToAddress(String address, double amount) throws RuntimeException {
        try {
            String txId = client.getClient().invoke("sendtoaddress", new Object[] { address, amount }, Object.class).toString();
            return txId;
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.signSendToAddress(String, double):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: address=%s,amount=%s", address, amount));
        }
    }

    @Override
    public Object multiSendToAddress(String fromaccount, Object target) throws RuntimeException {
        try {
            String txId = client.getClient().invoke("sendmany", new Object[] { fromaccount, target }, Object.class).toString();
            return txId;
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.signSendToAddress(String, double):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: fromaccount=%s,target=%s", fromaccount, target));
        }
    }

    @Override
    public Object getTrawtransaction(String txId, int verbose) throws RuntimeException {
        try {
            return client.getClient().invoke("getrawtransaction", new Object[] { txId, verbose }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.getTrawtransaction(String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: txId=%s", txId));
        }
    }

    @Override
    public Object getTransaction(String txId) throws RuntimeException {
        try {
            return client.getClient().invoke("gettransaction", new Object[] { txId }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.getTransaction(String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: txId=%s", txId));
        }
    }

    @Override
    public Object setAccount(String address, String account) throws RuntimeException {
        try {
            return client.getClient().invoke("setaccount", new Object[] { address, account }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.setAccount(String, String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: address=%s,account=%s", address, account));
        }
    }

    @Override
    public Object listReceivedByAddress(int minconf) throws RuntimeException {
        try {
            if (1 != minconf) {
                return client.getClient().invoke("listreceivedbyaccount", new Object[] { minconf }, Object.class);
            } else {
                return client.getClient().invoke("listreceivedbyaccount", new Object[] {}, Object.class);
            }
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.BtcServiceImpl.listReceivedByAddress(int minconf):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: minconf=%s", minconf));
        }
    }

    @Override
    public Object settxfee(double account) throws RuntimeException {
        try {
            return client.getClient().invoke("settxfee", new Object[] { account }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.settxfee(double):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: account=%s", account));
        }
    }

    @Override
    public Object encryptwallet(String passphrase) throws RuntimeException {
        try {
            return client.getClient().invoke("encryptwallet", new Object[] { passphrase }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.encryptwallet(String) ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Object walletpassphrase(String passphrase, int timeout) throws RuntimeException {
        try {
            return client.getClient().invoke("walletpassphrase", new Object[] { passphrase, timeout }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.walletpassphrase(String, int):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: passphrase=%s,timeout=%s", passphrase, timeout));
        }
    }

    @Override
    public Object createrawTransaction(Object transferInfo, Object sendInfo) throws RuntimeException {
        try {
            return client.getClient().invoke("createrawtransaction", new Object[] { transferInfo, sendInfo }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.createrawTransaction(Object):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: transferInfo=%s,sendInfo=%s", transferInfo, sendInfo));
        }
    }

    @Override
    public Object signrawTransaction(String hexstring, Object transferInfo) throws RuntimeException {
        try {
            return client.getClient().invoke("signrawtransaction", new Object[] { hexstring, transferInfo }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.signrawTransaction(String, Object):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: hexstring=%s,transferInfo=%s", hexstring, transferInfo));
        }
    }

    @Override
    public Object sendrawTransaction(String hexHash) throws RuntimeException {
        try {
            return client.getClient().invoke("sendrawtransaction", new Object[] { hexHash }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.sendrawTransaction(String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: hexHash=%s", hexHash));
        }
    }


    @Override
    public Object decoderawtransaction(String hex) throws RuntimeException {
        try {
            return client.getClient().invoke("decoderawtransaction", new Object[] { hex }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.wallet.bit.service.btc.impl.BtcServiceImpl.decoderawtransaction(String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: hex=%s", hex));
        }
    }


    @Override
    public String getBlockCount() throws RuntimeException {
        try {
            return client.getClient().invoke("getblockcount", new Object[] {}, Object.class).toString();
        } catch (Throwable e) {
            LOG.info("=== com.wallet.bit.service.btc.impl.BtcServiceImpl.getBlockCount():{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage());

        }
    }

    @Override
    public Object getBlockHash(int index) throws RuntimeException {
        try {
            return client.getClient().invoke("getblockhash", new Object[]{index}, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.wallet.bit.service.btc.impl.BtcServiceImpl.getBlockHash(int):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: index=%s", index));
        }
    }


    @Override
    public Object getblock(String blockHash) throws RuntimeException {
        try {
            return client.getClient().invoke("getblock", new Object[] { blockHash }, Object.class);
        } catch (Throwable e) {
            LOG.info("=== com.bscoin.bit.service.btc.impl.BtcServiceImpl.getblock(String):{} ===", e.getMessage(), e);
            throw new RuntimeException(e.getMessage() + String.format("[params]: blockHash=%s", blockHash));
        }
    }

}

