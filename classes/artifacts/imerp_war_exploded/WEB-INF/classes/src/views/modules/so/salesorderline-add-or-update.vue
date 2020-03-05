<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="销售单id" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="销售单id"></el-input>
    </el-form-item>
    <el-form-item label="商品id" prop="productId">
      <el-input v-model="dataForm.productId" placeholder="商品id"></el-input>
    </el-form-item>
    <el-form-item label="下单数" prop="orderQty">
      <el-input v-model="dataForm.orderQty" placeholder="下单数"></el-input>
    </el-form-item>
    <el-form-item label="实际交货数" prop="realQty">
      <el-input v-model="dataForm.realQty" placeholder="实际交货数"></el-input>
    </el-form-item>
    <el-form-item label="销售价" prop="price">
      <el-input v-model="dataForm.price" placeholder="销售价"></el-input>
    </el-form-item>
    <el-form-item label="当前成本价" prop="costPrice">
      <el-input v-model="dataForm.costPrice" placeholder="当前成本价"></el-input>
    </el-form-item>
    <el-form-item label="税率" prop="taxRate">
      <el-input v-model="dataForm.taxRate" placeholder="税率"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="创建人" prop="createBy">
      <el-input v-model="dataForm.createBy" placeholder="创建人"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="createDate">
      <el-input v-model="dataForm.createDate" placeholder="创建日期"></el-input>
    </el-form-item>
    <el-form-item label="修改人" prop="updateBy">
      <el-input v-model="dataForm.updateBy" placeholder="修改人"></el-input>
    </el-form-item>
    <el-form-item label="修改日期" prop="updateDate">
      <el-input v-model="dataForm.updateDate" placeholder="修改日期"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          orderId: '',
          productId: '',
          orderQty: '',
          realQty: '',
          price: '',
          costPrice: '',
          taxRate: '',
          remark: '',
          createBy: '',
          createDate: '',
          updateBy: '',
          updateDate: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '销售单id不能为空', trigger: 'blur' }
          ],
          productId: [
            { required: true, message: '商品id不能为空', trigger: 'blur' }
          ],
          orderQty: [
            { required: true, message: '下单数不能为空', trigger: 'blur' }
          ],
          realQty: [
            { required: true, message: '实际交货数不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '销售价不能为空', trigger: 'blur' }
          ],
          costPrice: [
            { required: true, message: '当前成本价不能为空', trigger: 'blur' }
          ],
          taxRate: [
            { required: true, message: '税率不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          createBy: [
            { required: true, message: '创建人不能为空', trigger: 'blur' }
          ],
          createDate: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
          ],
          updateBy: [
            { required: true, message: '修改人不能为空', trigger: 'blur' }
          ],
          updateDate: [
            { required: true, message: '修改日期不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/so/salesorderline/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.salesorderline.orderId
                this.dataForm.productId = data.salesorderline.productId
                this.dataForm.orderQty = data.salesorderline.orderQty
                this.dataForm.realQty = data.salesorderline.realQty
                this.dataForm.price = data.salesorderline.price
                this.dataForm.costPrice = data.salesorderline.costPrice
                this.dataForm.taxRate = data.salesorderline.taxRate
                this.dataForm.remark = data.salesorderline.remark
                this.dataForm.createBy = data.salesorderline.createBy
                this.dataForm.createDate = data.salesorderline.createDate
                this.dataForm.updateBy = data.salesorderline.updateBy
                this.dataForm.updateDate = data.salesorderline.updateDate
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/so/salesorderline/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'productId': this.dataForm.productId,
                'orderQty': this.dataForm.orderQty,
                'realQty': this.dataForm.realQty,
                'price': this.dataForm.price,
                'costPrice': this.dataForm.costPrice,
                'taxRate': this.dataForm.taxRate,
                'remark': this.dataForm.remark,
                'createBy': this.dataForm.createBy,
                'createDate': this.dataForm.createDate,
                'updateBy': this.dataForm.updateBy,
                'updateDate': this.dataForm.updateDate
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
