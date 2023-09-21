import React from 'react';
// @mui
import { SxProps, styled } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell, { tableCellClasses } from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

// types
import { IAerodrome } from 'src/@types/aerodrome';

// ----------------------------------------------------------------------

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  '&:nth-of-type(odd)': {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  '&:last-child td, &:last-child th': {
    border: 0,
  },
}));

// ----------------------------------------------------------------------

interface IAerodromesTableProps {
  aerodromes: IAerodrome[];
  sx?: SxProps;
};

const AerodromesTable: React.FC<IAerodromesTableProps> = ({ aerodromes, sx }) => (
  <TableContainer component={Paper}>
    <Table sx={{ minWidth: 700, ...sx }} aria-label="customized table" size="small">
      <TableHead>
        <TableRow>
          <StyledTableCell>Nome</StyledTableCell>
          <StyledTableCell>Cidade</StyledTableCell>
          <StyledTableCell>DMS</StyledTableCell>
          <StyledTableCell>Data de Criação</StyledTableCell>
          <StyledTableCell>Qtd de Pistas</StyledTableCell>
        </TableRow>
      </TableHead>
      <TableBody>
        {aerodromes.map((a) => (
          <StyledTableRow key={a.id}>
            <StyledTableCell component="th" scope="row">
              {a.name}
            </StyledTableCell>
            <StyledTableCell>{a.city}</StyledTableCell>
            <StyledTableCell>{a.dms}</StyledTableCell>
            <StyledTableCell>{a.createdAt}</StyledTableCell>
            <StyledTableCell>{a.runways.length}</StyledTableCell>
          </StyledTableRow>
        ))}
      </TableBody>
    </Table>
  </TableContainer>
);

export default AerodromesTable;