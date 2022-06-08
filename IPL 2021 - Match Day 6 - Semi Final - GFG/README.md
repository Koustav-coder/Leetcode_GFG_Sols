# IPL 2021 - Match Day 6 - Semi Final
## Hard 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">IPL 2021 knockouts are over, teams MI, CSK, DC, and RCB are qualified for the semis. </span></p>

<p><span style="font-size:18px">Today is matchday 6 and it is between Delhi Capitals and Royal Challengers Banglore. Glenn Maxwell of RCB playing flawlessly. Rishabh Pant, the new captain of the team who is also a wicket-keeper wants to send a message to the bowler. But, he can't&nbsp;shout message directly as a batsman can hear. So, he decided to encrypt the message by putting '*'s in the message. And this is how the bowler decrypts the message. Bowler iterates over the message string from left to right, if he finds a <strong>'*'</strong>, he removes it and adds all the letters read so far to the message. He keeps on doing this till he gets rid of all the <strong>'*'</strong>. Given a decrypted message in the form of the string, the task is to find the encrypted</span> <span style="font-size:18px">message</span>.</p>

<p><span style="font-size:18px"><strong>Note:</strong> If the string can be encrypted in multiple ways, find&nbsp;the encrypted string of smallest length.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong> s = "ababcababcd"
<strong>Output:</strong> ab*c*d
<strong>Explanation: </strong>We can encrypt the string 
in following way : "ababcababcd"&nbsp;-&gt; 
"ababc*d" -&gt; "ab*c*d"</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>s = "zzzzzzz"
<strong>Output:</strong> z*z*z
<strong>Explanation: </strong>The string can be encrypted 
in 2 ways: "z*z*z" and "z**zzz". Out of 
the two "z*z*z" is smaller in length.</span></pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function <strong>compress()</strong> which takes the message string <strong>s</strong> as input parameter and returns the shortest possible encrypted&nbsp;string.</span></p>

<p><span style="font-size:18px"><strong>Constraints:&nbsp;</strong><br>
1 ≤ |s| ≤ 10<sup>5</sup></span></p>
 <p></p>
            </div>