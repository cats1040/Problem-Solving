// Copyright 2025 Shreya Sharma

#include <bits/stdc++.h>

/**
 * This function prints the optimal drug
 * dosage for a patient using priority
 * queue.
 */
void solve() {
    int n, k;
    std::cin >> n >> k;

    /**
     * Stores medicine currTime, priority, frequency
     * and medicine name.
     */
    std::priority_queue<
        std::pair<std::vector<int>, std::string>,
        std::vector<std::pair<std::vector<int>, std::string>>,
        std::greater<std::pair<std::vector<int>, std::string>>
    > meds;

    for (int i = 0; i < n; i++) {
        std::string med;
        int freq;
        std::cin >> med >> freq;

        meds.push({{freq, i, freq}, med});
    }

    while (k > 0) {
        std::string med = meds.top().second;
        int time = meds.top().first[0];  // current time
        int priority = meds.top().first[1];  // priority
        int freq = meds.top().first[2];  // original freq to add to current time

        meds.pop();

        std::cout << time << " " << med << "\n";

        meds.push({{freq + time, priority, freq}, med});

        k--;
    }

    return;
}

int main() {
    int t;
    std::cin >> t;

    while (t--) {
        solve();
    }

    return 0;
}
