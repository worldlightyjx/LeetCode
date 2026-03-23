the key point to this problem is to check where current window size is greater than the (maxHistoryCharacterShowUptimes + K)

if curWindowSize > (maxHistoryCharacterShowUptimes + K)
    there is not enough replacement times to meet the target, then slide the window, there is no need to expand the window
else
    means within the k times replacement, characters within current window can be changed to has the longest repeating substring, so record the answer,then let the window expand

