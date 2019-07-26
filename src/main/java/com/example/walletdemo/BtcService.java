package com.example.walletdemo;

/**
 * @Author Miccke
 * @Description TODO
 * @Date $ $
 * @Version 2.0.4
 **/
public interface BtcService {


    /**
     * @throws Throwable
     * @throws RuntimeException
     * @Title: validateaddress 验证钱包地址是否有效
     * @param @param address
     * @param @return    参数
     * @return boolean    返回类型
     * @throws
     */
    boolean validateAddress(String address) throws  RuntimeException;


    /**
     * @throws RuntimeException
     * @Title: getBalance
     * @param @param account
     * @param @return    参数
     * @return Object    返回类型
     * @throws
     */
    double getBalance(String  account) throws RuntimeException;


    /**
     * @throws RuntimeException
     * @Title: signSendToAddress
     * @param @param address
     * @param @param amount
     * @param @return    参数
     * @return Object    返回类型
     * @throws
     * <amount>是一个实数，并四舍五入到小数点后8位。如果成功，则返回事务ID <txid>
     */
    Object signSendToAddress(String address,double amount) throws RuntimeException;


    /**
     * @throws RuntimeException
     * @Title: multiSendToAddress
     * @param @param fromaccount
     * @param @param target
     * @param @return    参数
     * @return Object    返回类型
     * @throws
     */
    Object multiSendToAddress(String fromaccount,Object target) throws RuntimeException;


    /**
     * @throws RuntimeException
     * @Title: getTransaction
     * @param @param txId
     * @param @return    参数
     * @return Object    返回类型
     * @throws
     */
    Object getTrawtransaction(String txId,int verbose) throws RuntimeException;


    /**
     * @Title: createrawTransaction
     * @param @param transferInfo
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    Object createrawTransaction(Object transferInfo,Object sendInfo) throws RuntimeException;


    /**
     * @Title: signrawTransaction
     * @param @param hexstring
     * @param @param transferInfo
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    Object signrawTransaction(String hexstring, Object transferInfo) throws RuntimeException;


    /**
     * @Title: sendrawTransaction
     * @param @param hexHash
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */

    Object sendrawTransaction(String hexHash) throws RuntimeException;



    /**
     * @Title: decoderawtransaction
     * @param @param hex
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    Object decoderawtransaction(String hex) throws RuntimeException;
    /**
     * @Title: getTransaction
     * @param @param txId
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */

    Object getTransaction(String txId) throws RuntimeException;

    /**
     * @throws RuntimeException
     * @Title: setAccount
     * @param @param address
     * @param @param account
     * @param @return    参数
     * @return Object    返回类型
     * @throws
     */
    Object setAccount(String address,String account) throws RuntimeException;


    /**
     * @Title: listReceivedByAddress
     * @param @param minconf
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    Object listReceivedByAddress(int minconf) throws RuntimeException;


    /**
     * @Title: settxfee
     * @param @param account
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */

    Object settxfee(double account) throws RuntimeException;


    /**
     * @Title: encryptwallet
     * @param @param passphrase
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */

    Object encryptwallet(String passphrase) throws RuntimeException;


    /**
     * @Title: walletpassphrase
     * @param @param passphrase
     * @param @param timeout
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */

    Object walletpassphrase(String passphrase,int timeout) throws RuntimeException;



    /**
     * @Title: blockCount
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    String getBlockCount() throws RuntimeException;


    /**
     * @Title: getBlockHash
     * @param @param index
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    Object getBlockHash(int index) throws RuntimeException;

    /**
     * @Title: getblock
     * @param @param blockHash
     * @param @return
     * @param @throws RuntimeException    参数
     * @return Object    返回类型
     * @throws
     */
    Object getblock(String blockHash) throws RuntimeException;

}
