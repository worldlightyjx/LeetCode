The key point of this problem is to decide when to expand window other than slide it.

Use a cnt to count the character frequency within current window and decide when

cnt[currentChar] > 1 means it appears duplicate character, then should we slide the window

else continue to expand the window by increase the right border