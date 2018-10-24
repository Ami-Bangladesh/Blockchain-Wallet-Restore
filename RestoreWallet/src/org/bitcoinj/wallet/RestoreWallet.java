/**
 * 
 */
package org.bitcoinj.wallet;

import java.math.BigInteger;
import java.util.List;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.crypto.HDUtils;
import org.bitcoinj.params.TestNet3Params;

//import com.squareup.okhttp.Credentials;
import org.web3j.crypto.Credentials;



/**
 * @author CRAZYPROGRAMMER
 *
 */
public class RestoreWallet {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		NetworkParameters params = TestNet3Params.get();
		String seedCode = "alien mail double bird table float market picnic pluck flock stay shy";
		String passphrase = "";
		int creationtime = 1540322595;
		DeterministicSeed seed = new DeterministicSeed(seedCode, null, passphrase, creationtime);
		Wallet wallet = Wallet.fromSeed(params, seed);
		System.out.println(wallet.toString());
		DeterministicKeyChain chain = DeterministicKeyChain.builder().seed(seed).build();
		List<ChildNumber> keyPath = HDUtils.parsePath("M/44H/60H/0H/0/0");
		DeterministicKey key = chain.getKeyByPath(keyPath, true);
		BigInteger privKey = key.getPrivKey();
		
		// Web3j
		Credentials credentials = Credentials.create(privKey.toString(16));
		System.out.println(credentials.getAddress());
		
	}

}
