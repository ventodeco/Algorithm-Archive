class Solution {
public:
  double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    // ngegabungin array 1 dan array 2 v
    // sorting arrayGabungan v
    // cek apakah jumlah array genap / ganjil v
    // ganjil -> arr[size/2]
    // genap -> arr[size/2] + arr[(size/2)+1]

    nums1.insert(nums1.end(), nums2.begin(), nums2.end());

    sort(nums1.begin(), nums1.end());

    if (nums1.size()%2 == 1) {
        return (double) nums1[nums1.size()/2];
    }
    // 0, 1, 2, 3
    // 1, 2, 3, 4
    //       2

    return (double) (nums1[nums1.size()/2] + nums1[(nums1.size()/2)-1])/2;
  }
};
