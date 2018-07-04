class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        def quick_select(arr, left, right):
            pivot = left
            l, r = left, right
            while l < r:
                while l < r and arr[r][1] <= arr[pivot][1]:
                    r -= 1
                while l < r and arr[l][1] >= arr[pivot][1]:
                    l += 1
                arr[l], arr[r] = arr[r], arr[l]
            arr[left], arr[l] = arr[l], arr[left]

            if l + 1 == k:
                return arr[:l+1]
            elif l + 1 < k:
                return quick_select(arr, l + 1, right)
            else:
                return quick_select(arr, left, l - 1)

            if not nums:
                return []
        
        # Get the counts.
        counter = {}
        for x in nums:
            counter[x] = counter.get(x, 0) + 1
        
        counter = counter.items()
        # Use quick select to get the top k counts.
        return [numd[0] for numd in quick_select(counter, 0, len(counter) - 1)]